package com.commondemo.xiaoyu.commondemo

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.commondemo.xiaoyu.commondemo", appContext.packageName)
    }

    @get:Rule
    public val mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun buttonTest(){
        /**
         *  with表示定位的意思
         *  withId根据控件id定位
         *  withText 根据控件内容文本定位
         */
        onView(withId(R.id.retrofit_button)).perform(click())//.check(matches(withText("RETROFIT")))
    }


}
