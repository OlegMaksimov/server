package ru.maksimov.service;

import ru.maksimov.entities.UserProfile;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *     Сервис работы с учетными записями
 * </p>
 */
public class AccountService {
    private final Map<String,UserProfile> userAssignMap = new ConcurrentHashMap<>();

    /**
     * <p>
     *     Регистриация пользователя
     * </p>
     * @param userProfile полльзовательский профиль
     */
    public void signUp(UserProfile userProfile) {
        userAssignMap.put(userProfile.getLogin(), userProfile);
    }

    /**
     * <p>
     *     Проверяет наличие пользователя в системе
     * </p>
     * @param userProfile профиль пользователя
     * @return true, если пользователь зарегистрирован
     */
    public Boolean signIn(UserProfile userProfile) {
        UserProfile profile = userAssignMap.get(userProfile.getLogin());
        return profile != null && profile.getPassword().equals(userProfile.getPassword());
    }


}
