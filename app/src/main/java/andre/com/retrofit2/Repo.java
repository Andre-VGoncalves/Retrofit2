package andre.com.retrofit2;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andrevieira on 19/01/2018.
 */

public class Repo {

    @SerializedName("id")
    int mId;

    @SerializedName("name")
    String mName;

    public Repo(int mId, String mName) {
        this.mId = mId;
        this.mName = mName;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
