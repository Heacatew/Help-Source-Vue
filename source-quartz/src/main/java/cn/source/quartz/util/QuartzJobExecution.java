package cn.source.quartz.util;

import org.quartz.JobExecutionContext;
import cn.source.quartz.domain.SysJob;

/**
 * 定时任务处理（允许并发执行）
 * 
 * @author source
 *
 */
public class QuartzJobExecution extends AbstractQuartzJob
{
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception
    {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
