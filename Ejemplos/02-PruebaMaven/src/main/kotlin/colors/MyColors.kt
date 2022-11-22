package colors

import com.diogonunes.jcolor.AnsiFormat
import com.diogonunes.jcolor.Attribute.*


var fInfo = AnsiFormat(CYAN_TEXT())
var fError = AnsiFormat(YELLOW_TEXT(), RED_BACK())
var fWarning = AnsiFormat(GREEN_TEXT(), BLUE_BACK(), BOLD())
var fNormal = AnsiFormat(MAGENTA_BACK(), YELLOW_TEXT())
var fBright = AnsiFormat(BRIGHT_MAGENTA_BACK(), BRIGHT_YELLOW_TEXT())