package net.churchofgod.cogmedia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TabAboutUs extends Fragment {
    private static final String TAG = "TabAboutUs";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_about_us,container,false);

        TextView textView = view.findViewById(R.id.aboutUs);
        textView.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }

    private void setContentView(int fragment_tab_about_us) {

    }
}
