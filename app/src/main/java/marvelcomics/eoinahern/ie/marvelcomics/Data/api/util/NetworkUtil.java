package marvelcomics.eoinahern.ie.marvelcomics.Data.api.util;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {

	private Context context;
	private ConnectivityManager cm;

	public NetworkUtil(Context context) {
		this.context = context;
		this.cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	}

	public boolean isConnected() {
		NetworkInfo netinfo = cm.getActiveNetworkInfo();
		return netinfo != null && netinfo.isConnectedOrConnecting();
	}
}
