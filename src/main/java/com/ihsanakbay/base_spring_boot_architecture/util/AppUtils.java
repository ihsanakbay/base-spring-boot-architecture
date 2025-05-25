package com.ihsanakbay.base_spring_boot_architecture.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class AppUtils {

    private AppUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Creates a Pageable instance with the given page, size and sort parameters
     *
     * @param page     Page number (0-based)
     * @param size     Page size
     * @param sortBy   Field to sort by
     * @param sortDir  Sort direction (asc or desc)
     * @return Pageable instance
     */
    public static Pageable createPageable(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        return PageRequest.of(page, size, sort);
    }

    /**
     * Formats a LocalDateTime to a string using the specified pattern
     *
     * @param dateTime LocalDateTime to format
     * @param pattern  Pattern to use for formatting
     * @return Formatted date string
     */
    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    /**
     * Generates a random UUID string
     *
     * @return Random UUID string
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * Checks if a string is null or empty
     *
     * @param str String to check
     * @return true if string is null or empty, false otherwise
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Checks if a string is not null and not empty
     *
     * @param str String to check
     * @return true if string is not null and not empty, false otherwise
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
