package ammar.zeny.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AmmarZeny implements EntryPoint {
	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync ammar = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final TextArea x=new TextArea();
		final TextArea y=new TextArea();
		final TextArea z=new TextArea();
	    
	    final Button button = new Button("Submit");

		
	   
		RootPanel.get().add(x);
		
		RootPanel.get().add(y);
		 
		RootPanel.get().add(z);
		RootPanel.get().add(button);

		
		
	button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
			button.setEnabled(true);
			button.setFocus(true);
			}
		});

		
		class MyHandler implements ClickHandler, KeyUpHandler {
			
			public void onClick(ClickEvent event) {
				callServer();
			}

			
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					callServer();
				}
			}

			
			private void callServer() {
								
				int aa=Integer.valueOf(x.getText());
		    	 int bb=Integer.valueOf(y.getText());
			     int cc=Integer.valueOf(z.getText());
				ammar.getRoots(aa,bb,cc,new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								Window.alert("fail to connect to server....");
							}

							public void onSuccess(String result) {
								Window.alert(result);
							}
						});
			}
		}

		
		MyHandler handler = new MyHandler();
		button.addClickHandler(handler);
	}
}
