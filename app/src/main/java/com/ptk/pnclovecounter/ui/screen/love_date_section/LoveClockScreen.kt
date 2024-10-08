import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ptk.pnclovecounter.ui.ui_resource.composable.RealTimeClock
import com.ptk.pnclovecounter.ui.ui_resource.theme.LemonFontFamily
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit

@Composable
fun LoveClockScreen(
    startDate: LocalDate?,
    endDate: LocalDate?,
    period: Period?,
    modifier: Modifier = Modifier
) {
    LoveClockScreenContent(startDate = startDate, endDate = endDate, period)
}

@Composable
fun LoveClockScreenContent(
    startDate: LocalDate?,
    endDate: LocalDate?,
    period: Period?,
    modifier: Modifier = Modifier
) {
    period?.let {
        val years = period.years
        val months = period.months

        // Calculate total days after considering full years and months
        val totalDays = ChronoUnit.DAYS.between(
            startDate?.plusYears(years.toLong())?.plusMonths(months.toLong()),
            endDate
        )

        // Calculate weeks and remaining days from the total days
        val weeks = (totalDays / 7).toInt()
        val remainingDays = (totalDays % 7).toInt()


        Column(
            modifier = modifier
                .fillMaxSize(),
        ) {
            Spacer(modifier = modifier.height(32.sdp))
            Column(modifier = modifier.background(Color.Black.copy(alpha = 0.3f)).padding(vertical = 8.sdp)) {
                Column {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        HeartWithText(value = years, label = "years", modifier = modifier)
                        HeartWithText(value = months, label = "months", modifier = modifier)
                        HeartWithText(value = weeks, label = "weeks", modifier = modifier)
                    }
                    Spacer(modifier = modifier.height(8.sdp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        HeartWithText(value = remainingDays, label = "days", modifier = modifier)
                    }
                    Spacer(modifier = modifier.height(16.sdp))

                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(end = 16.sdp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        RealTimeClock()
                    }
                    Spacer(modifier = modifier.height(16.sdp))

                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(end = 16.sdp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "\u2764 6.May.2024 \u2764",
                            color = Color.White,
                            fontSize = 24.ssp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = LemonFontFamily,
                            textAlign = TextAlign.Center,
                            modifier = modifier.padding(top = 8.sdp)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun HeartWithText(value: Int, label: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            TransparentHeart()

            Text(
                text = "$value",
                color = Color.White,
                fontSize = 20.ssp,
                fontWeight = FontWeight.Bold,
                fontFamily = LemonFontFamily,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(top = 8.sdp)
            )

        }
        Text(
            text = label,
            color = Color.White,
            fontSize = 11.ssp,
            fontWeight = FontWeight.Bold,
            fontFamily = LemonFontFamily,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(top = 8.sdp)
        )
    }

}

@Composable
fun TransparentHeart(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .height(60.sdp)
            .width(100.sdp)
    ) {
        val path = Path().apply {
            // Start from the center top of the heart
            moveTo(size.width / 2, size.height / 4)

            // Draw the right lobe of the heart with smoother curves
            cubicTo(
                size.width * 7 / 8, 0f,       // Control point 1 for top-right
                size.width * 7 / 8, size.height * 2 / 3,  // Control point 2 for bottom-right
                size.width / 2, size.height   // End at the bottom tip of the heart
            )

            // Draw the left lobe of the heart with smoother curves
            cubicTo(
                size.width * 1 / 8, size.height * 2 / 3,  // Control point 1 for bottom-left
                size.width * 1 / 8, 0f,      // Control point 2 for top-left
                size.width / 2, size.height / 4  // End at the starting point to close the path
            )
            close()
        }

        // Drawing the path with a transparent red color and a stroke width of 4.dp
        drawPath(
            path = path,
            color = Color.White,
            style = Stroke(width = 4.dp.toPx())
        )
    }
}






