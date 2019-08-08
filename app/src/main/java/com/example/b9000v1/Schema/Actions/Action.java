package com.example.b9000v1.Schema.Actions;

public abstract class Action {

    public enum ActionType {
        Like, Comment, Subscription
    }

    public abstract String getDescription();
}


