package com.mod.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mod.smartbulb.R;

/**
 * Created by yangc on 2015/7/5.
 */
public class MyProgressDialog {
    private Dialog mProgressDlg;
    private Context mContext;
    private boolean isCanceledOnTouchOutside = false;
    private boolean isCancelable = true;
    LinearLayout mAlertDialogLayout;


    public MyProgressDialog(Context ctx) {
        this.mContext = ctx;
    }


    public Dialog getProgressDialog() {
        return mProgressDlg;

    }

    public void dismissProgressDlg() {
        if (mProgressDlg != null && mProgressDlg.isShowing())
            mProgressDlg.dismiss();
    }

    public void showProgressDlg(String msg) {
        try {
            if (mProgressDlg == null) {
                mProgressDlg = new Dialog(mContext, R.style.Theme_Dialog);
                mProgressDlg.setContentView(mAlertDialogLayout = (LinearLayout) LayoutInflater.from(mContext).inflate(
                        R.layout.loading_view, null));
                mProgressDlg.setCanceledOnTouchOutside(isCanceledOnTouchOutside);
                mProgressDlg.setCancelable(isCancelable);
            }
            ((TextView) mAlertDialogLayout.findViewById(R.id.text1)).setText(msg);
            mProgressDlg.show();
        } catch (Exception e) {

        }
    }

    public void setIsCanceledOnTouchOutside(boolean is) {
        isCanceledOnTouchOutside = is;
    }

    public void setIsCancelable(boolean is) {
        isCancelable = is;
    }
}
