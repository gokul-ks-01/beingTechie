package myproject.setorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import myproject.test.TestCase;

public class TestCaseMethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		Map<Integer, IMethodInstance> orders = new TreeMap<Integer, IMethodInstance>();

		for (IMethodInstance iMethodInstance : methods) {
			if (!iMethodInstance.getMethod().getMethodName().equals("testCaseMethod")) {
				continue;
			}
			Object obj = iMethodInstance.getInstance();
			if (!(obj instanceof TestCase)) {
				continue;
			}
			TestCase test = (TestCase) obj;
			Integer order = test.getOrder();
			orders.put(order, iMethodInstance);
		}
		List<IMethodInstance> tests = new ArrayList<IMethodInstance>(orders.size());
		for (Integer order : orders.keySet()) {
			IMethodInstance test = orders.get(order);
			tests.add(test);
		}
		return tests;

	}

}
