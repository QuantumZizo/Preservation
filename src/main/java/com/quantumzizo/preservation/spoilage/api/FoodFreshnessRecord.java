package com.quantumzizo.preservation.spoilage.api;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record FoodFreshnessRecord(int freshnessTime, int spoilageTime, boolean hasSpoiled) {
    public static final Codec<FoodFreshnessRecord> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("freshnessTime").forGetter(FoodFreshnessRecord::freshnessTime),
                    Codec.INT.fieldOf("spoilageTime").forGetter(FoodFreshnessRecord::spoilageTime),
                    Codec.BOOL.fieldOf("hasSpoiled").forGetter(FoodFreshnessRecord::hasSpoiled)
            ).apply(instance, FoodFreshnessRecord::new)
    );

    public static final StreamCodec<ByteBuf,FoodFreshnessRecord> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, FoodFreshnessRecord::freshnessTime,
            ByteBufCodecs.INT, FoodFreshnessRecord::spoilageTime,
            ByteBufCodecs.BOOL, FoodFreshnessRecord::hasSpoiled,
            FoodFreshnessRecord::new
    );
}