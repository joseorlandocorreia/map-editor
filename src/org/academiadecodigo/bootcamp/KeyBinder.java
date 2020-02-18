package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class KeyBinder {

    private Keyboard keyboard;

    private KeyboardEvent upKeyPress = new KeyboardEvent();
    private KeyboardEvent downKeyPress = new KeyboardEvent();
    private KeyboardEvent leftKeyPress = new KeyboardEvent();
    private KeyboardEvent rightKeyPress = new KeyboardEvent();
    private KeyboardEvent spaceKeyPress = new KeyboardEvent();
    private KeyboardEvent spaceKeyReleased = new KeyboardEvent();
    private KeyboardEvent toggleKeyPress = new KeyboardEvent();

    public KeyBinder(Keyboard keyboard) {
        this.keyboard = keyboard;
        setKeys();
    }

    public void setKeys() {
        upKeyPress.setKey(KeyboardEvent.KEY_UP);
        upKeyPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upKeyPress);

        downKeyPress.setKey(KeyboardEvent.KEY_DOWN);
        downKeyPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downKeyPress);

        leftKeyPress.setKey(KeyboardEvent.KEY_LEFT);
        leftKeyPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftKeyPress);

        rightKeyPress.setKey(KeyboardEvent.KEY_RIGHT);
        rightKeyPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightKeyPress);

        spaceKeyPress.setKey(KeyboardEvent.KEY_SPACE);
        spaceKeyPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceKeyPress);

        spaceKeyReleased.setKey(KeyboardEvent.KEY_SPACE);
        spaceKeyReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(spaceKeyReleased);

        toggleKeyPress.setKey(KeyboardEvent.KEY_T);
        toggleKeyPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(toggleKeyPress);
    }
}
