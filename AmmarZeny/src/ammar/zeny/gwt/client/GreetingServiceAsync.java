package ammar.zeny.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	

	void getRoots(int x, int y, int z, AsyncCallback<String> callback);
}
