package com.dotd.api.core.temp;

import com.dotd.api.core.temp.Temp;

public interface TempRepository {
    Long save(Temp temp);

    Temp find(Long id);
}
