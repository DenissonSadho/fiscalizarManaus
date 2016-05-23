package com.sadho.denisson.fiscalizarmanaus.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Herber on 22/05/2016.
 */
public class MediaStoreUtil {

    public static final int MEDIA_TYPE_IMAGE = 100;

    public static Intent getPickImageIntent(final Context context) {

        Uri fileUri;
        final Intent mCamera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        mCamera.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);


        /*final Intent mGallery = new Intent(Intent.ACTION_GET_CONTENT, null);
        mGallery.setType("image/*");
        mGallery.addCategory(Intent.CATEGORY_OPENABLE);

        final Intent chooser = new Intent(Intent.ACTION_CHOOSER);
        chooser.putExtra(Intent.EXTRA_INTENT, mGallery);
        chooser.putExtra(Intent.EXTRA_TITLE, "Foto Ocorrencia");

        Intent[] intentArray = { mCamera };
        chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray);

        return chooser;
        */
        return mCamera;
    }

    /** Create a file Uri for saving an image or video */
    public static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");

        } else {
            return null;
        }

        return mediaFile;
    }

}
