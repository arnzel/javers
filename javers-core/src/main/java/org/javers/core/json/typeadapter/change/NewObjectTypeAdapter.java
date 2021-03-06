package org.javers.core.json.typeadapter.change;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.javers.common.collections.Optional;
import org.javers.core.commit.CommitMetadata;
import org.javers.core.diff.changetype.NewObject;
import org.javers.core.metamodel.type.TypeMapper;

class NewObjectTypeAdapter extends ChangeTypeAdapter<NewObject> {

    public NewObjectTypeAdapter(TypeMapper typeMapper) {
        super(typeMapper);
    }

    @Override
    public NewObject fromJson(JsonElement json, JsonDeserializationContext context) {
        JsonObject jsonObject = (JsonObject) json;

        return appendCommitMetadata(jsonObject, context, new NewObject(deserializeAffectedCdoId(jsonObject,context), Optional.empty()));
    }

    @Override
    public Class getValueType() {
        return NewObject.class;
    }
}
