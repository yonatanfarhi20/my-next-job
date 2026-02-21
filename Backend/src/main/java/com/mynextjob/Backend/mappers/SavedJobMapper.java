package com.mynextjob.Backend.mappers;

import com.mynextjob.Backend.dtos.savedjob.SavedJobResponse;
import com.mynextjob.Backend.models.SavedJob;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {JobMapper.class})
public interface SavedJobMapper {

    // המרה לישות של משרה שמורה לתצוגה
    // ה-JobMapper יטפל אוטומטית בהמרת ה-Job ל-JobShortResponse
    @Mapping(target = "job", source = "job")
    SavedJobResponse toResponse(SavedJob savedJob);

    // הערה: אין צורך ב-toEntity כאן כי השמירה עצמה
    // מתבצעת ב-Service על ידי חיבור IDs של משתמש ומשרה
}