package getresult.example.asus.nottspark;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserProfile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserProfile extends Fragment {

    private EditText profileName, profileEmail, profileContact;
    private Spinner vehicleSpinner;
    private Button editProfile;

    public UserProfile() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_profile, container, false);
        profileName = (EditText)rootView.findViewById(R.id.profileName);
        profileEmail = (EditText)rootView.findViewById(R.id.profileEmail);
        profileContact = (EditText)rootView.findViewById(R.id.profileContact);

        profileName.setKeyListener(null);
        profileEmail.setKeyListener(null);
        profileContact.setKeyListener(null);

        // Inflate the layout for this fragment
        return rootView;
    }
}
