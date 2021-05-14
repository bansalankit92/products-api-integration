package com.integration.extensions.domains.devops.util;


import com.integration.extensions.domains.devops.Build;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;


public class BuildCheckTimer extends Timer {

    private final CountDownLatch done;
    private final BuildCheckTask task;
    public Build build;

    public BuildCheckTimer(RestClient client, Build build) {
        this.build = build;
        done = new CountDownLatch(1);
        task = new BuildCheckTask(client, build, done);
        schedule(task, 0, 5000);
    }

    public void waitTillFinish() throws InterruptedException {
        done.await();
        build = task.build;
        this.cancel();
    }

    private static class BuildCheckTask extends TimerTask {

        private Build build;
        private final RestClient client;
        private final CountDownLatch done;

        public BuildCheckTask(RestClient client, Build build, CountDownLatch done) {
            this.client = client;
            this.build = build;
            this.done = done;
        }

        @Override
        @lombok.SneakyThrows
        public void run() {
            build = BuildUtil.getById(client, build.buildId);
            if (build.state.equals(BuildUtil.STATE_FINISHED)) {
                done.countDown();
            }
        }
    }
}
