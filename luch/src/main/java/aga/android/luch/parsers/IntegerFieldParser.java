package aga.android.luch.parsers;

import java.util.List;

import androidx.annotation.NonNull;

public class IntegerFieldParser implements IFieldParser<Integer> {

    @Override
    public Integer consume(@NonNull List<Byte> packet) throws BeaconParseException {
        try {
            final int mostSigBits = packet.remove(0);
            final int leastSigBits = packet.remove(0);

            return (mostSigBits & 0xff) * 0x100 + (leastSigBits & 0xff);
        } catch (Exception e) {
            // todo handle at the BeaconParser level
            throw new BeaconParseException(
                "Could not parse the integer from the data packet ",
//                    + byteArrayToHexString(packet),
                e
            );
        }
    }

    @Override
    public void insert(@NonNull List<Byte> packet, @NonNull Integer value) {
        packet.add((byte) (value / 256));
        packet.add((byte) (value / 256));
    }

    @Override
    public void insertMask(@NonNull List<Byte> packet, byte maskBit) {
        packet.add(maskBit);
        packet.add(maskBit);
    }

    @Override
    public boolean canParse(@NonNull Class clazz) {
        return Integer.class.isAssignableFrom(clazz);
    }
}
