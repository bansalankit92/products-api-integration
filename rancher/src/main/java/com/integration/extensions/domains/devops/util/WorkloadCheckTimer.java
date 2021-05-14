package com.integration.extensions.domains.devops.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import com.integration.extensions.domains.devops.DeploymentWorkload;

public class WorkloadCheckTimer extends Timer {

    private final CountDownLatch done;
    private final WorkloadCheckTask task;
    public DeploymentWorkload workload;

    public WorkloadCheckTimer(RestClient client, DeploymentWorkload workload) {
        this.workload = workload;
        done = new CountDownLatch(1);
        task = new WorkloadCheckTask(client, workload, done);
        schedule(task, 2000, 5000);
    }

    public void waitTillFinish() throws InterruptedException {
        done.await(6, TimeUnit.MINUTES);
        workload = task.workload;
        this.cancel();
    }

    private static class WorkloadCheckTask extends TimerTask {

        private DeploymentWorkload workload;
        private final RestClient client;
        private final CountDownLatch done;

        public WorkloadCheckTask(RestClient client, DeploymentWorkload workload, CountDownLatch done) {
            this.client = client;
            this.workload = workload;
            this.done = done;
        }

        @Override
        @lombok.SneakyThrows
        public void run() {
            workload = WorkloadUtil.getById(client, workload.deploymentProjectId, workload.workloadId);
            if (workload.state.equals(WorkloadUtil.STATE_ACTIVE)) {
                done.countDown();
            }
        }
    }
}
