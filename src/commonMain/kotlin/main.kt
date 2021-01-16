import com.soywiz.klock.*
import com.soywiz.korge.*
import com.soywiz.korge.animate.animate
import com.soywiz.korge.animate.animateParallel
import com.soywiz.korge.tween.*
import com.soywiz.korge.view.*
import com.soywiz.korim.color.*
import com.soywiz.korim.format.*
import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.*
import com.soywiz.korma.interpolation.*

suspend fun main() = Korge(width = 512, height = 512, bgcolor = Colors["#2b2b2b"]) {
	val c = circle { }

	val bidenBitmap = resourcesVfs["biden.png"].readBitmap()
	val im = image(bidenBitmap) {
		xy(256,256)
		anchor(.5, .5)
		scale(.8)
	}

	while (true) {
		animate {
			parallel {
				c.moveToWithSpeed(100, 100, speed = 100)
				im.moveToWithSpeed(300, 100)
			}
			parallel {
				c.moveToWithSpeed(300, 300)
				im.moveToWithSpeed(100, 300)
			}
		}
	}
}