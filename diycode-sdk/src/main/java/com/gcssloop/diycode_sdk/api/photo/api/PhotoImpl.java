/*
 * Copyright 2017 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 2017-03-09 02:21:32
 *
 * GitHub:  https://github.com/GcsSloop
 * Website: http://www.gcssloop.com
 * Weibo:   http://weibo.com/GcsSloop
 */

package com.gcssloop.diycode_sdk.api.photo.api;

import android.content.Context;
import android.support.annotation.NonNull;

import com.gcssloop.diycode_sdk.api.base.callback.BaseCallback;
import com.gcssloop.diycode_sdk.api.base.implement.BaseImpl;
import com.gcssloop.diycode_sdk.api.photo.event.UploadPhotoEvent;
import com.gcssloop.diycode_sdk.utils.UUIDGenerator;

import java.io.File;

public class PhotoImpl extends BaseImpl<PhotoService> implements PhotoAPI {
    public PhotoImpl(@NonNull Context context) {
        super(context);
    }

    /**
     * 上传图片,请使用 Multipart 的方式提交图片文件
     *
     * @param img_file 图片文件
     * @see UploadPhotoEvent
     */
    @Override
    public String uploadPhoto(@NonNull File img_file) {
        String uuid = UUIDGenerator.getUUID();
        mService.uploadPhoto(img_file).enqueue(new BaseCallback<>(new UploadPhotoEvent(uuid)));
        return uuid;
    }
}
