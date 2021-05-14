import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.*;

public class JenkinsRunner {
    public static void main(String[] args) throws URISyntaxException, IOException {
        JenkinsServer jenkins = new JenkinsServer(new URI("http://54.164.112.174:8080"), "admin", "admin");
        Map<String, Job> jobs = jenkins.getJobs();
        Job job = jobs.get("maven-spring");

        job.build(true);
        //System.out.println(jobs.entrySet());
        System.out.println(job.details().getDisplayName());
        Build firstBuild = job.details().getFirstBuild();
        Build lastBuild = job.details().getLastBuild();
        BuildWithDetails lastBuildDetails = lastBuild.details();
        TestReport report = lastBuild.getTestReport();
        TestResult result = lastBuild.getTestResult();
        String output = lastBuild.details().getConsoleOutputText();
        System.out.println();
        System.out.println(job.details());



        TestSuites s = result.getSuites().get(0);


    }
}