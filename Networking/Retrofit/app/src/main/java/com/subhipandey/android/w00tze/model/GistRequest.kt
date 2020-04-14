package com.subhipandey.android.w00tze.model

import android.accounts.AuthenticatorDescription

class GistRequest (val description: String,val files: Map<String, GistFile>, val public: Boolean = true)