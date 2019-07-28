package com.xing.arthas.learning.trace.source;

import java.io.File;

/**
 * @author ralf0131 2016-12-28 16:20.
 */
public interface Constants {

    /**
     * Spy的全类名
     */
    String SPY_CLASSNAME = "java.arthas.Spy";

    /**
     * 中断提示
     */
    String Q_OR_CTRL_C_ABORT_MSG = "Press Q or Ctrl+C to abort.";

    /**
     * 空字符串
     */
    String EMPTY_STRING = "";

    /**
     * 命令提示符
     */
    String DEFAULT_PROMPT = "$ ";

    /**
     * 方法执行耗时
     */
    String COST_VARIABLE = "cost";

    String CMD_HISTORY_FILE = System.getProperty("user.home") + File.separator + ".arthas" + File.separator + "history";

    /**
     * 当前进程PID
     */
    String PID = ApplicationUtils.getPid();
}
