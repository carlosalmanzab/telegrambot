package com.leyos_telegram_bot_manager.telegrambot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.abilitybots.api.objects.Locality;
import org.telegram.telegrambots.abilitybots.api.objects.Privacy;
import org.telegram.telegrambots.longpolling.BotSession;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.AfterBotRegistration;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.meta.generics.TelegramClient;


public class BotStarter extends AbilityBot implements SpringLongPollingBot {

    protected BotStarter(TelegramClient telegramClient, String botUsername) {
        super(telegramClient, botUsername);
    }

    public Ability sayHelloWorld() {
        return Ability
                .builder()
                .name("hello")
                .info("says hello world")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(context -> silent.send("Hello World!", context.chatId()))
                .build();
    }

    @Override
    public long creatorId() {
        return 1L;
    }

    @Override
    public String getBotToken() {
        return Config.token;
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return this;
    }

    @AfterBotRegistration
    public void afterRegistration(BotSession botSession) {
        this.onRegister();
    }

}
