/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */


object BuildVersion {
    const val compileSdkVersion = 31
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
}


object Kotlin {

    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.32"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2"
}

/**
 * AndroidX 相关依赖
 * 最新版本可参考：https://developer.android.com/jetpack/androidx/versions?hl=zh-cn
 */
object Androidx {

    const val appcompat = "androidx.appcompat:appcompat:1.4.0"

    //core
    const val core = "androidx.core:core:1.7.0"
    const val core_ktx = "androidx.core:core-ktx:1.7.0"
    const val core_runtime = "androidx.arch.core:core-runtime:2.1.0"

    //activity
    const val activity = "androidx.activity:activity:1.4.0"
    const val activity_ktx = "androidx.activity:activity-ktx:1.4.0"

    //fragment
    const val fragment = "androidx.fragment:fragment:1.3.6"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:1.3.6"

    //lifecycle
    const val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
    const val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    const val lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:2.3.1"
    const val lifecycle_common_java8 = "androidx.lifecycle:lifecycle-common-java8:2.3.1"
    const val lifecycle_service = "androidx.lifecycle:lifecycle-service:2.3.1"
    const val lifecycle_process = "androidx.lifecycle:lifecycle-process:2.3.1"
    const val lifecycle_reactivestreams_ktx =
        "androidx.lifecycle:lifecycle-reactivestreams-ktx:2.3.1"

    //viewmodel
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel:2.3.1"
    const val viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"

    // liveData
    const val livedata = "androidx.lifecycle:lifecycle-livedata:2.3.1"
    const val livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
    const val livedata_unpeek = "com.kunminx.arch:unpeek-livedata:7.2.0-beta1"


    //room
    const val room_runtime = "androidx.room:room-runtime:2.3.0"
    const val room_compiler = "androidx.room:room-compiler:2.3.0"
    const val room_rxjava2 = "androidx.room:room-rxjava2:2.3.0"
    const val room_rxjava3 = "androidx.room:room-rxjava3:2.3.0"

    //hilt
    const val hilt_android = "com.google.dagger:hilt-android:2.36"
    const val hilt_compiler = "com.google.dagger:hilt-compiler:2.36"


    //view
    const val coordinatorlayout = "androidx.coordinatorlayout:coordinatorlayout:1.1.0"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.1"
    const val recyclerview = "androidx.recyclerview:recyclerview:1.2.1"
    const val viewpager = "androidx.viewpager:viewpager:1.0.0"
    const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"

    //paging
    const val paging_runtime = "androidx.paging:paging-runtime:3.0.0"
    const val paging_rxjava2 = "androidx.paging:paging-rxjava2:3.0.0"
    const val paging_rxjava3 = "androidx.paging:paging-rxjava3:3.0.0"

    // navigation Kotlin
    val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:2.3.5"
    val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:2.3.5"

    //work
    const val work_runtime = "androidx.work:work-runtime:2.5.0"
    const val work_runtime_ktx = "androidx.work:work-runtime-ktx:2.5.0"
    const val work_rxjava2 = "androidx.work:work-rxjava2:2.5.0"

    //media
    const val media = "androidx.media:media:1.3.1"

    const val webkit = "androidx.webkit:webkit:1.4.0"
}

object Google {
    const val material = "com.google.android.material:material:1.4.0"
    const val exoplayer = "com.google.android.exoplayer:exoplayer:2.15.1"
    const val exoplayer_dash = "com.google.android.exoplayer:exoplayer-dash:2.15.1"
    const val exoplayer_ui = "com.google.android.exoplayer:exoplayer-ui:2.15.1"
    const val gson = "com.google.code.gson:gson:2.8.8"

}


object Deps {

    //okhttp
    const val okhttp = "com.squareup.okhttp3:okhttp:4.9.2"
    const val okhttp_logging = "com.squareup.okhttp3:logging-interceptor:4.9.2"

    //retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    const val adapter_rxjava2 = "com.squareup.retrofit2:adapter-rxjava2:2.9.0"
    const val adapter_rxjava3 = "com.squareup.retrofit2:adapter-rxjava3:2.9.0"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:2.9.0"
    const val converter_moshi = "com.squareup.retrofit2:converter-moshi:2.9.0"
    const val converter_simplexml = "com.squareup.retrofit2:converter-simplexml:2.9.0"

    //rxjava
    const val rxjava3 = "io.reactivex.rxjava3:rxjava:3.0.13"

    //rxandroid
    const val rxandroid = "io.reactivex.rxjava3:rxandroid:3.0.0"

    const val BRVAH = "com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.4"

    //smart_refresh_layout
    const val refresh_layout_kernel = "com.scwang.smart:refresh-layout-kernel:2.0.3"      //核心必须依赖
    const val refresh_header_classics = "com.scwang.smart:refresh-header-classics:2.0.3"    //经典刷新头
    const val refresh_footer_classics = "com.scwang.smart:refresh-footer-classics:2.0.3"    //经典加载

    const val lottie = "com.airbnb.android:lottie:4.2.1"


    //glide
    const val glide = "com.github.bumptech.glide:glide:4.12.0"
    const val glideCompiler = "com.github.bumptech.glide:compiler:4.12.0"
    const val glide_transformations = "jp.wasabeef:glide-transformations:4.3.0"
    const val glide_gpuimage = "jp.co.cyberagent.android:gpuimage:2.1.0"


    //eventbus
    const val eventbus = "org.greenrobot:eventbus:3.2.0"

    //gson
    const val gson = "com.google.code.gson:gson:2.8.7"

    //autosize
    const val autosize = "me.jessyan:autosize:1.2.1"

    const val xxpermissions = "com.github.getActivity:XXPermissions:10.8"

    const val mmkv = "com.tencent:mmkv-static:1.2.7"

    const val toastutils = "com.github.getActivity:ToastUtils:9.0"

    //各种工具库
    const val utils = "com.blankj:utilcodex:1.30.6"

    const val aroute = "com.alibaba:arouter-api:1.5.1"
    const val aroute_processor = "com.alibaba:arouter-compiler:1.5.1"
    const val agentweb = "com.just.agentweb:agentweb-androidx:4.1.3"

    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:2.7"

    val SmartRefreshLayout = SmartRefreshLayoutObject

    object SmartRefreshLayoutObject {
        const val Kernel = "com.scwang.smart:refresh-layout-kernel:2.0.3"
        const val HeaderClassics = "com.scwang.smart:refresh-header-classics:2.0.3"
        const val FooterClassics = "com.scwang.smart:refresh-footer-classics:2.0.3"
    }
}


object Tests {
    const val junit = "junit:junit:4.13.2"
    const val androidx_junit = "androidx.test.ext:junit:1.1.3"
    const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
}


