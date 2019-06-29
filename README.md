# LibTest

It works for auto validation for authentication and API call.

## Setup:
**Step 1**. Add the JitPack repository to your build file

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
**Step 2**. Add the dependency

```
	dependencies {
	        implementation 'com.github.NazranKhondokar:LibTest:0.3.1'
	}
```
**Step 3**. For above Java 8

```
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
```
**Step 4**. Add this code to your Application class

```
        ClearableCookieJar cookieJar1 = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));

        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);

//        CookieJarImpl cookieJar1 = new CookieJarImpl(new MemoryCookieStore());
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new LoggerInterceptor("TAG"))
                .cookieJar(cookieJar1)
                .hostnameVerifier((hostname, session) -> true)
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .build();
        OkHttpUtils.initClient(okHttpClient);
```
**Step 5**. Add Application class name to Manifest application

**Step 6**. Make Two Pojo class for body and response

**Step 7**. Then call like below

```
    private static final String BASE_URL = "";
    private static final String TOKEN_VALUE = "";
    private static final String CONTENT_TYPE = "";
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> params = new HashMap<>();
    
    ....
    
    new AuthRequest<RegisterUser>(BASE_URL, "register", headers, CONTENT_TYPE, registerUser,
                new StringCallback<RegisterUserResponse>(new RegisterUserResponse(), new ResponseListener<RegisterUserResponse>() {
                    @Override
                    public void onResponse(Response response) {
                        Log.e(TAG, "Code: " + response.code());
                        Log.e(TAG, "Message: " + response.message());
                        Log.e(TAG, "CodeMessage: " + new StatusCode(response.code()).checkStatusCode());
                    }

                    @Override
                    public void onResponseObject(RegisterUserResponse responseObject) {
                        Log.e(TAG, "Status: " + responseObject.getStatus());
                    }
                }) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "Error: " + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e(TAG, "String: " + response);
                    }
                }).callPOST();
    
```

## Some variation

```
    /**
     * when no request object and no parameters available, this time content type add to header
     */
    AuthRequest(String mBaseUrl, String endPoint, Map<String, String> headers, StringCallback stringCallback) {}
```
```
    /**
     * when no request object but headers, parameters available, this time content type add to header
     */
    AuthRequest(String mBaseUrl, String endPoint, Map<String, String> headers, Map<String, String> params, StringCallback stringCallback) {}
```
```
    /**
     * when POST request and parameters available
     */
     callPOSTWithParams()
```
```
    /**
     * when GET request and parameters available
     */
     callGETWithParams()
```
## For Auto validation

```
    <com.rokomari.authlib.formvalidator.widget.FormEditText
    
        ...
        
        app:hintType="firstName"
        app:validationType="personName" />
```
## Grateful to them

[OKHttpUtils](https://github.com/hongyangAndroid/okhttputils)

[FormValidator](https://github.com/ShabanKamell/FormValidator)
