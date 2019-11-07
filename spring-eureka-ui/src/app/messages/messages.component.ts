import { Component, OnInit } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { ajax, css } from "jquery";
import $ from 'jquery';
@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.scss']
})
export class MessagesComponent implements OnInit {


  ngOnInit() {
  }
  private serverUrl = 'http://localhost:9300/socket'
  //private serverUrl = 'http://localhost:8762/chat/socket'
  public title = 'Tribes chat';
  private stompClient;

  constructor(){
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection(){
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/chat", (message) => {
        if(message.body) {
          $(".chat").append("<div class='message'>"+message.body+"</div>")
          console.log(message.body);
        }
      });
    });
  }

  sendMessage(message){
    this.stompClient.send("/app/send/message" , {}, message);
    $('#input').val('');
  }

}
