package com.scorpio.mywebview

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
    {

        /** esta sera  la url que nosotros utilizamos junto con la de google para realizar busque_
        das en su motor, el ?q es para la queri. Que quiere decir la variable, que si nosotros
        escribimos la variable paginicio mas search path mas el it, buscara eso en el motor de google*/
        private val Search_PATH = "/search?q="

        /** aqui se creara la operacion para manejar los componentes, y se ingresara codigo para las
                    * diferentes funcionalidades que buscamos*/
        override fun onCreate(savedInstanceState: Bundle?)
        {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**  aqui accederemos al swipe refresh layout (al componente, su id se configura en el layout)
                    *  y podremos darle funcionalidad segun el codigo que escribamos*/
        /** El setOnRefreshListener es una funcion predefinida q hará que cuando nosotros usemos
         *  el refresh en nuestra app  se invoque el sgte codigo ( en este caso, ordenarle un reload*/
        swipeRefreshLayout.setOnRefreshListener {
            webView.reload()
        }
        /**aqui implementamos nuestros 2 clientes para el webview con el objetivo de configurar el
            * mismo. Dentro de estos dos bloques es donde podremos acceder a diferentes operaciones
            * que serviran para interactuar con el webview. */
        webView.webChromeClient = object : WebChromeClient()
        {

            }
        webView.webViewClient = object : WebViewClient()
        {
            /** para interactuar con nuestro webview sera facilisimo, nos colocamos dentro del bloque y haremos
            * * * * el overrride de varias operaciones, vamos a sobreeescribir distintas opciones para decidir
            * nosotros, como se van a comportar, EN ESTE CASO SERAN 3:
            *
            * la primera es una operacion que casi siempre vamos a tener que reimplementar
            * * en nuestros webview xq lo que hace es cedernos el control sobre el manejo de
            * las cargas de nuevas urls y asi vamos a manejar las nuevas cargas de las urls.
            *
            * la segunda operacion nos indica  que una nueva pagina se va a cargar en nuestro
            * webview, con ella veremos cuando una nueva url  se empieza a cargar, y le ordenaremos hacer
            * lo que ta dentro de la operacion (el swipe refresh layout, si se refresca, retorna true)
            *
            * la tercera operacion sera pa ordenarle que hacer despues de que carge la pag, en este
            * caso, ocultar el refresh layout.
            *
            * asi de facil es comunicarse con nuestro webview, pues simplemente si quereis realizar
            * diferentes interacciones  tendreis que buscar operaciones en el webviewclient o en el otro
            * , de esta manera se podra tener constancia de odo lo que esta haciendo nuestrto visor
            * web*/

            /** 1)*/
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean
                {
                        return false
                        }

            /** 2)*/
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?)
                {
                        super.onPageStarted(view, url, favicon)
                            /** cada vez que cargamos una URl, vamos a hacer que se muestre en la barra
                            * de busqueda, para asi saber en tod0 momento, la url en la que estamos
                            * navegando*/
                            searchView.setQuery(url, false)
                            swipeRefreshLayout.isRefreshing = true
                        }

            /** 3)*/
                override fun onPageFinished(view: WebView?, url: String?)
                {
                        super.onPageFinished(view, url)
                            swipeRefreshLayout.isRefreshing = false
                        }
        }
        /**Por defecto un webview no tiene configurado el javascript, por lo cual nosotros tambien
           deberemos configurarlo. Para hacerlo tendremos que acceder a los settings, a las
           variables de configuracion del webview (accedemos con el codigo de la linea de abajito) */
        val settings: WebSettings = webView.settings
        /** ahoora que accedimos a los settings de webView, podemos programar los cambios que
            * querramos y no es necesario cerrar los settings luego de ello */
        settings.javaScriptEnabled = true
        /**  una vez que ya tenemos configurado nuestro webView, ya podremos cargar nuestra
        * pagina web de inicio. Abajo, estamos configurando la pagina de inicio al parecer y se hace
         * de la sgte manera*/
        val pagInicio = "https://google.com"
        webView.loadUrl(pagInicio)
        /** ahora vamos a implementar y darle funcionalidad a nuestra barra de busqueda / search
         * view. el lisener que tenemos que implementar para saber cuando de verdad el usuario
         * esta escribiendo algo  y le da al boton buscar es el query de abajo y el
         * onquerytextlistener nos va a permitir sobreescribir dos operaciones para poder inte
         * ractuar con la barra de busqueda. Borramos el TOD0 de cada una de ellas y las imple
         * mentaremos a nuestro gusto. la primera operacion text change nos permite que si queremos
         * delegar en ese componente, como actuar en el momento en que estamos haciendo una busqueda
         * , es decir si queremos que nos suguiera busquedas que ya hemos realizado anteriormente y
         * todos sus comportamientos por defecto que ya tiene esta barra de busqueda, en este caso,
         * le diremos que no, ya que vamos a ser nosotros mismos los que vamos a manejar el compor
         * tamiento del buscador. La TEXTSUBMIT se invoca cuando el usuario escribe algo y le da
         * al boton buscar, si nosotros vamos a la barra y pulsamos en ella. vemos que aparece el
         * teclado y cuando nosotros pulsamos la lupa del teclado, este teclado se va a cerrar y va
         * a invocar esta operacion (TEXTSUBMIT). Este sera el momento en el que nosotros vamos a
         * acceder al texto que ha introducido el usuario y vamos a intentar realizar una busqueda con
         * el en nuestro webview. En este caso le daremos return false para asi manejar nosotros el
         * comportamiento de este buscador*/
        searchView.setOnQueryTextListener   ( object: SearchView.OnQueryTextListener
        {
            /** el texto que introduce en usuario se guarda en newText, como tiene ? puede ser nulo o
            * contener texto */
                override fun onQueryTextChange(newText: String?): Boolean
                {
                    /** accedemos  al texto con let (esto lo desempaqueta y lo guarda en it) y si es distinto
                    *  de nulo, ejecuta el codigo en cuestion */
                        newText?.let{
                        if (URLUtil.isValidUrl(it))
                        {
                                webView.loadUrl(it)
                            }
                        else
                        {
                                webView.loadUrl("$pagInicio$Search_PATH$it")
                            }
                                    }
                        return false
                }

            /** el texto que introduce el usuario se guarda en query, como tiene ? puede ser nulo o
            * puede tener texto */
                override fun onQueryTextSubmit(query: String?): Boolean
                {
                    return false
                }

        }
                                            )
    }

        /** para incluir la funcionalidad de los botones < o y cuadrado, de la parte inferior de la
    * *  pantalla, debemos crear una operacion onbackpressed, en la que pondremos: aqui vamos a
    *  acceder a nuestro webview y ordenarle ejecutar el siguiente codigo
    */
        override fun onBackPressed() {

        /**  en caso de que el webView ya no pueda ir mas hacia atras,
        llamamos al super, que en este caso nos va a desencadenar las opciones restantes
        que haria por defecto que puede ser el salir de la aplicacion.*/
            if (webView.canGoBack()) {
            webView.goBack()
            } else {
            super.onBackPressed() }
    }

     }


