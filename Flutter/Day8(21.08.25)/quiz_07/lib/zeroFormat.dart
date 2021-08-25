class ZeroFormat {
  String monthZero(int month) {
    String workMonth = "";
    if (month < 10) {
      workMonth = "0$month";
    } else {
      workMonth = "$month";
    }
    return workMonth;
  }

  String dayZero(int day) {
    String workDay = "";
    if (day < 10) {
      workDay = "0$day";
    } else {
      workDay = "$day";
    }
    return workDay;
  }

  String hourZero(int hour) {
    String workHour = "";
    if (hour < 10) {
      workHour = "0$hour";
    } else {
      workHour = "$hour";
    }
    return workHour;
  }

  String minuteZero(int minute) {
    String workMinute = "";
    if (minute < 10) {
      workMinute = "0$minute";
    } else {
      workMinute = "$minute";
    }
    return workMinute;
  }

  String secondZero(int second) {
    String workSecond = "";
    if (second < 10) {
      workSecond = "0$second";
    } else {
      workSecond = "$second";
    }
    return workSecond;
  }

  String weekday(int weekday) {
    String workWeekday = "";
    switch (weekday) {
      case 0:
        workWeekday = "일";
        break;
      case 1:
        workWeekday = "월";
        break;
      case 2:
        workWeekday = "화";
        break;
      case 3:
        workWeekday = "수";
        break;
      case 4:
        workWeekday = "목";
        break;
      case 5:
        workWeekday = "금";
        break;
      case 6:
        workWeekday = "토";
        break;
    }
    return workWeekday;
  }
}
