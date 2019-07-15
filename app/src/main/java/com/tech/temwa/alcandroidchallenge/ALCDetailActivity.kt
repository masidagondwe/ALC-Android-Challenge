package com.tech.temwa.alcandroidchallenge

import android.app.Activity
import android.net.http.SslError
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.MenuItem
import android.webkit.*
import android.widget.Toast
import com.tech.temwa.alcandroidchallenge.R.id.webviewALCPage
import kotlinx.android.synthetic.main.activity_alcdetail.*

class ALCDetailActivity : AppCompatActivity() {

    //var mywebview: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alcdetail)

       // setSupportActionBar(toolbar)
       // supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // Get the web view settings instance
        val settings = webviewALCPage.settings

        // Enable java script in web view
        settings.javaScriptEnabled = true

        // Enable and setup web view cache
        settings.setAppCacheEnabled(true)
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.setAppCachePath(cacheDir.path)

        webviewALCPage.webViewClient = MyWebViewClient(this)
        webviewALCPage.loadUrl("https://andela.com/alc/")

        /*  mywebview = findViewById<WebView>(R.id.webviewALCPage)
          mywebview!!.webViewClient = object : WebViewClient() {
              override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest ?): Boolean {
                  val url = request?.getUrl().toString()
                  view?.loadUrl(url)
                  return true
              }
          }
          mywebview!!.loadUrl("https://www.google.co.in/")*/
    }

    class MyWebViewClient internal constructor(private val activity: Activity) : WebViewClient() {

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url: String = request?.url.toString();
            view?.loadUrl(url)
            return true
        }

        @SuppressWarnings("deprecation")
        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            webView.loadUrl(url)
            return true
        }

        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            Toast.makeText(activity, "Got Error! $error", Toast.LENGTH_SHORT).show()
        }

        @Override
        override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
            handler?.proceed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home){
            finish()
        }
        return true
    }




}



