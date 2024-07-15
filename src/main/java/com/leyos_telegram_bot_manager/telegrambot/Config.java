package com.leyos_telegram_bot_manager.telegrambot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Configuration
public class Config {


    @Value("${telegram.bot.token}")
    public static  String token = "6332387670:AAE11gu5vCarOd9nkMzvEF3KhfF5hOQ39mg";

    @Value("${telegram.bot.name}")
    public static  String name = "LEYOS_BOT";

    @Bean
    public BotStarter botStarter() {
        return new BotStarter(telegramClient(), name);
    }

    @Bean
    public TelegramClient telegramClient() {
        return new OkHttpTelegramClient(token);
    }
}
