package com.xing.arthas.demo;

import com.sun.tools.attach.VirtualMachine;
import com.xing.arthas.agent.AgentBoot;

import java.io.File;
import java.util.Optional;

public class AttachMain {
    public static void main(String[] args) {
        String agentFilePath = AgentBoot
                .class
                .getResource("/")
                .getPath()
                .replaceAll("/classes", "")
                .replaceAll("arthas-demo-attach", "arthas-demo-test-agent")
                .concat("arthas-demo-test-agent-1.0-jar-with-dependencies.jar");
        //System.out.println(agentFilePath);
        String appName = "FooMain";

        //查到需要监控的进程
        Optional<String> processId = Optional.ofNullable(VirtualMachine.list()
                .stream()
                .filter(jvm -> jvm.displayName().contains(appName))
                .findFirst().orElseThrow(() -> new RuntimeException("Target App not found")).id());

        File agentFile = new File(agentFilePath);
        try {
            String jvmPid = processId.get();
            System.out.println("Attaching to target JVM with PID: " + jvmPid);
            VirtualMachine jvm = VirtualMachine.attach(jvmPid);
            System.out.println(agentFile.getAbsoluteFile());
            jvm.loadAgent(agentFile.getAbsolutePath());
            jvm.detach();
            System.out.println("Attached to target JVM and loaded Java agent successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
