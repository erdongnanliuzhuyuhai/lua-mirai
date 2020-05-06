package com.ooooonly.luaMirai.lua;

import com.ooooonly.luaMirai.lua.LuaObject;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

public abstract class LuaSource extends LuaObject {
    public static final int RECALL = 0;

    private static LuaTable metaTable;

    public LuaSource() {
        super();
    }

    @Override
    protected LuaTable getMetaTable() {
        if (metaTable != null) return metaTable;
        metaTable = new LuaTable();
        LuaTable index = new LuaTable();

        index.set("recall", getOpFunction(RECALL));

        metaTable.set("__index", index);
        return metaTable;
    }

    @Override
    public int type() {
        return TYPE_SOURCE;
    }
}
