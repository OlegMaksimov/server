package ru.maksimov.service;

import ru.maksimov.entities.UserProfile;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     Сервис работы с учетными записями
 * </p>
 */
public class AccountService {
    private Map<String,String> userAssignMap = new HashMap<>();

    /**
     * <p>
     *     Регистриация пользователя
     * </p>
     * @param userProfile
     */
    public void signUp(UserProfile userProfile) {
        if (signIn(userProfile)) {
            throw new RuntimeException("Пользователь уже зарегестрирован");
        } else {
            userAssignMap.put(userProfile.getLogin(),userProfile.getPassword());
        }

    }

    /**
     * <p>
     *     Проверяет наличие пользователя в системе
     * </p>
     * @param userProfile профиль пользователя
     * @return
     */
    public Boolean signIn(UserProfile userProfile) {
        if (userAssignMap.get(userProfile.getLogin()) == null) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }


}
