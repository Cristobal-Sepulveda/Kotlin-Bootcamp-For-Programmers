package com.scorpio.pensadora

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import kotlinx.android.synthetic.main.activity_synonymous.*

class SynonymousActivity : AppCompatActivity() {
    /* Variables a Utilizar */
    val synonymous = "https://www.google.com/search?q=sinonimo+de "
    /* Variables a Utilizar */

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_synonymous)

        val settings: WebSettings = webViewSynonymous.settings
        settings.javaScriptEnabled = true

        swipeRefreshLayoutSynonymous.setOnRefreshListener {
            webViewSynonymous.reload()
        }

        webViewSynonymous.webChromeClient = object : WebChromeClient() {

        }
        webViewSynonymous.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean
            {
                return false
            }
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?)
            {
                super.onPageStarted(view, url, favicon)
                swipeRefreshLayoutSynonymous.isRefreshing = true
            }
            override fun onPageFinished(view: WebView?, url: String?)
            {
                super.onPageFinished(view, url)
                swipeRefreshLayoutSynonymous.isRefreshing = false
            }

        }

        /* get data from another activity */
        var intent = intent
        var msg = intent.getStringExtra("msg")
        webViewSynonymous.loadUrl("$synonymous$msg")
    }

    /**  en caso de que el webView ya no pueda ir mas hacia atras,
    llamamos al super, que en este caso nos va a desencadenar las opciones restantes
    que haria por defecto que puede ser el salir de la aplicacion.*/
    override fun onBackPressed() {
        val intent2 = Intent(this, MainActivity::class.java)
        if (webViewSynonymous.canGoBack()) {
            startActivity(intent2)
            finish()
        } else {
            startActivity(intent2)
            finish()
        }
    }






}