import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import java.util.Set;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import com.example.mytests.RepeatedTestsDemo;


public class CalcTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
				.selectors(
						selectPackage("com.example.mytests"),
						selectClass(RepeatedTestsDemo.class)
						//selectClass(Class.forName("com.example.mytests.CalculatorTests"))
						)
						.filters(
								includeClassNamePatterns(".*Tests")
								
								)
								.build();

		Launcher launcher = (Launcher) LauncherFactory.create();

		TestPlan testPlan = launcher.discover(request);
		
		
		
		Set<TestIdentifier> rootsjupiter = testPlan.getChildren("[engine:junit-jupiter]");
		for (TestIdentifier testIdentifier : rootsjupiter) {
			System.out.println("id is ="+testIdentifier.getUniqueId());
		}
		
		
		Set<TestIdentifier> roots = testPlan.getRoots();
		for (TestIdentifier testIdentifier : roots) {
			System.out.println("id is ="+testIdentifier.getUniqueId());
		}
	}

}
