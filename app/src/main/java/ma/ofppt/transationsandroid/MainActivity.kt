package ma.ofppt.transationsandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.transition.Slide
import android.transition.TransitionManager
import android.view.animation.AnimationUtils
import ma.ofppt.transationsandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val transition = Slide(Gravity.RIGHT)
        transition.duration=1000
        TransitionManager.beginDelayedTransition(binding.root,transition)

        binding.btnActivity2.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.btnFadeIn.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.fade_in)
            anim.duration = 1000
            binding.card.startAnimation(anim)
        }
        binding.btnFadeOut.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.fade_out)
            anim.duration = 1000
            binding.card.startAnimation(anim)
        }
    }
}