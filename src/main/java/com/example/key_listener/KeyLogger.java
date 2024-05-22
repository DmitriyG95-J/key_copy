package com.example.key_listener;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyLogger implements NativeKeyListener {

    public static void main(String[] args) {
        // Отключаем вывод логов JNativeHook
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new KeyLogger());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.print(NativeKeyEvent.getKeyText(e.getKeyCode()) + " ");
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        // Необязательно обрабатывать событие
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        // Необязательно обрабатывать событие
    }
}
