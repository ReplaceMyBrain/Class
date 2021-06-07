package com.aoslec.fragmenttest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class ToolBarFragment extends Fragment {

    EditText editText = null;
    Button button = null;
    SeekBar seekBar = null;
    int seekValue = 10;

    ToolbarListener activityCallback;

    //----------------------------
    //MainActivity와의 통신을 위해 interface를 사용
    //MarinActivity에서는 implements로 사용
    //----------------------------

    public interface ToolbarListener{
        public void onButtonClick (int postion, String text);

    }

    //----------------------------
    //Fragment에서는 onAttach()가 제일 처음으로 실행
    //----------------------------
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.v("Message", "onAttach");
        try{
            activityCallback = (ToolbarListener) context;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        Log.v("Message", "f1_onCreateView");

        //layout 지정
        View view = inflater.inflate(R.layout.fragment_tool_bar,container,false);

        //layout에서 가져옴.
        editText = view.findViewById(R.id.f1_edit);
        button = view.findViewById(R.id.f1_button);
        seekBar = view.findViewById(R.id.f1_seek);

        //클릭 또는 seekbar움직일 시 메소드 지정
        button.setOnClickListener(mClickListener);
        seekBar.setOnSeekBarChangeListener(mSeekBarChangedListener);

        //view에 리턴해줌.
        return view;
    }

    //seekbar 메소드
    SeekBar.OnSeekBarChangeListener mSeekBarChangedListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            //벨류값을 지정해줌.
            Log.v("Message", "seekBar");
            seekValue = progress;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    //MainActivity의 onButtonClick()에서 실행
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.v("Message", "mClickListener");

            //메인에 콜백해줌 - 어떤것을 보내줄것인지 보내줌!
            activityCallback.onButtonClick(seekValue, editText.getText().toString());
        }
    };
}