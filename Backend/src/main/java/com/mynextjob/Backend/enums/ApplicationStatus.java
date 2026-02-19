package com.mynextjob.Backend.enums;

public enum ApplicationStatus {
    PENDING,        // המועמדות התקבלה במערכת
    IN_REVIEW,      // המגייסת/המנהל עוברים על קורות החיים
    INTERVIEWING,   // המועמד נמצא בתהליך ראיונות (שלב קריטי לסטטיסטיקה!)
    OFFER_SENT,     // נשלחה הצעת עבודה (חוזה)
    ACCEPTED,       // המועמד חתם והתקבל
    REJECTED,       // המועמדות נדחתה
    WITHDRAWN       // המועמד החליט להסיר את המועמדות מרצונו
}