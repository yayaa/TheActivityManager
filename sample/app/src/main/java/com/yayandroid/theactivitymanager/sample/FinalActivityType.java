package com.yayandroid.theactivitymanager.sample;

/**
 * Created by yahyabayramoglu on 06/04/15.
 */
public enum FinalActivityType {

    NONE(0, R.string.type_none),
    TO_LANDING(1, R.string.type_to_landing),
    REMOVE_INSTANCE(2, R.string.type_remove_instance),
    TO_INSTANCE(3, R.string.type_to_instance),
    STEP(4, R.string.type_step),
    QUIT(5, R.string.type_quit);

    public final int id;
    public final int textId;

    private FinalActivityType(int id, int textId) {
        this.id = id;
        this.textId = textId;
    }

    public static FinalActivityType getType(int id) {
        FinalActivityType[] types = FinalActivityType.values();
        for (int i = 0; i < types.length; i++)
            if (types[i].id == id)
                return types[i];
        return null;
    }

}
