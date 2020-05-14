package aga.android.luch.parsers;

import java.util.List;

import androidx.annotation.NonNull;

public class SingleByteFieldParser implements IFieldParser<Byte> {

    @Override
    public Byte consume(@NonNull List<Byte> packet) {
        return packet.remove(0);
    }

    @Override
    public void insert(@NonNull List<Byte> packet, @NonNull Byte value) {
        packet.add(value);
    }

    @Override
    public void insertMask(@NonNull List<Byte> packet, byte maskBit) {
        packet.add(maskBit);
    }

    @Override
    public boolean canParse(@NonNull Class clazz) {
        return Byte.class.isAssignableFrom(clazz);
    }
}
