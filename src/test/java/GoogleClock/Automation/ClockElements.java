package GoogleClock.Automation;

public class ClockElements {
	
	//Alarm activity elements
	String alaramIconEle_accesId = "Alarm";
	String addAlarmEle_accesId = "Add alarm";
	String AlarmTimePickerEle_id = "com.google.android.deskclock:id/material_timepicker_mode_button";
	String AlarmTxtInpSwitcherEle_id = "//android.widget.Button[@content-desc='Switch to text input mode for the time input.']";
	String txtSelctTimeHrEle_xpath = "//android.widget.FrameLayout[@resource-id='com.google.android.deskclock:id/material_hour_text_input']//android.widget.EditText";
	String txtSelctTimeMinEle_xpath = "//android.widget.FrameLayout[@resource-id='com.google.android.deskclock:id/material_minute_text_input']//android.widget.EditText";
	String txtSelctTimePMeEle_id = "com.google.android.deskclock:id/material_clock_period_pm_button";
	String txtSelctTimeOKBtn_xpath = "//android.widget.Button[@resource-id='com.google.android.deskclock:id/material_timepicker_ok_button']";
	String alrmCardExpndAddLabl_id = "com.google.android.deskclock:id/edit_label";
	String alrmLablTxtField_id = "com.google.android.deskclock:id/label_input_field";
	String alrmLablOkBtn_id= "android:id/button1";
	String alrmCardExpndSelctMonDay_accesId = "Monday";
	String alrmCardExpndPauseAlrmIcon_accesId= "remove pause alarm period";
	String pauseAlrmNxtMnthArrow_accesId= "Change to next month";
	String pauseAlrmStrtDt_androidUIAutomator = "new UiSelector().text(\"17\")";
	String pauseAlrmEndDt_androidUIAutomator = "new UiSelector().text(\"27\")";
	String pauseAlrmDialogOKBtn_id = "com.google.android.deskclock:id/confirm_button";
	
}
