(function(g){var window=this;'use strict';var B4=function(a){g.V.call(this,{D:"div",K:"ytp-miniplayer-ui"});this.cg=!1;this.player=a;this.N(a,"minimized",this.hg);this.N(a,"onStateChange",this.oC)},C4=function(a){g.mM.call(this,a);
this.i=new B4(this.player);this.i.hide();g.$L(this.player,this.i.element,4);a.Ge()&&(this.load(),g.L(a.getRootNode(),"ytp-player-minimized",!0))};
g.v(B4,g.V);g.k=B4.prototype;
g.k.LA=function(){this.tooltip=new g.LP(this.player,this);g.G(this,this.tooltip);g.$L(this.player,this.tooltip.element,4);this.tooltip.scale=.6;this.jc=new g.hN(this.player);g.G(this,this.jc);this.vg=new g.V({D:"div",K:"ytp-miniplayer-scrim"});g.G(this,this.vg);this.vg.Aa(this.element);this.N(this.vg.element,"click",this.Sw);var a=new g.V({D:"button",Ca:["ytp-miniplayer-close-button","ytp-button"],U:{"aria-label":"Close"},S:[g.pK()]});g.G(this,a);a.Aa(this.vg.element);this.N(a.element,"click",this.Nh);
a=new g.j0(this.player,this);g.G(this,a);a.Aa(this.vg.element);this.Pn=new g.V({D:"div",K:"ytp-miniplayer-controls"});g.G(this,this.Pn);this.Pn.Aa(this.vg.element);this.N(this.Pn.element,"click",this.Sw);var b=new g.V({D:"div",K:"ytp-miniplayer-button-container"});g.G(this,b);b.Aa(this.Pn.element);a=new g.V({D:"div",K:"ytp-miniplayer-play-button-container"});g.G(this,a);a.Aa(this.Pn.element);var c=new g.V({D:"div",K:"ytp-miniplayer-button-container"});g.G(this,c);c.Aa(this.Pn.element);this.tI=new g.IO(this.player,
this,!1);g.G(this,this.tI);this.tI.Aa(b.element);b=new g.FO(this.player,this);g.G(this,b);b.Aa(a.element);this.nextButton=new g.IO(this.player,this,!0);g.G(this,this.nextButton);this.nextButton.Aa(c.element);this.xg=new g.yP(this.player,this);g.G(this,this.xg);this.xg.Aa(this.vg.element);this.Dc=new g.NO(this.player,this);g.G(this,this.Dc);g.$L(this.player,this.Dc.element,4);this.Fw=new g.V({D:"div",K:"ytp-miniplayer-buttons"});g.G(this,this.Fw);g.$L(this.player,this.Fw.element,4);a=new g.V({D:"button",
Ca:["ytp-miniplayer-close-button","ytp-button"],U:{"aria-label":"Close"},S:[g.pK()]});g.G(this,a);a.Aa(this.Fw.element);this.N(a.element,"click",this.Nh);a=new g.V({D:"button",Ca:["ytp-miniplayer-replay-button","ytp-button"],U:{"aria-label":"Close"},S:[g.uK()]});g.G(this,a);a.Aa(this.Fw.element);this.N(a.element,"click",this.VQ);this.N(this.player,"presentingplayerstatechange",this.Cc);this.N(this.player,"appresize",this.ob);this.N(this.player,"fullscreentoggled",this.ob);this.ob()};
g.k.show=function(){this.rd=new g.ln(this.Lo,null,this);this.rd.start();this.cg||(this.LA(),this.cg=!0);0!==this.player.getPlayerState()&&g.V.prototype.show.call(this);this.Dc.show();this.player.unloadModule("annotations_module")};
g.k.hide=function(){this.rd&&(this.rd.dispose(),this.rd=void 0);g.V.prototype.hide.call(this);this.player.Ge()||(this.cg&&this.Dc.hide(),this.player.loadModule("annotations_module"))};
g.k.va=function(){this.rd&&(this.rd.dispose(),this.rd=void 0);g.V.prototype.va.call(this)};
g.k.Nh=function(){this.player.stopVideo();this.player.Ma("onCloseMiniplayer")};
g.k.VQ=function(){this.player.playVideo()};
g.k.Sw=function(a){if(a.target===this.vg.element||a.target===this.Pn.element)g.R(this.player.T().experiments,"kevlar_miniplayer_play_pause_on_scrim")?g.sJ(this.player.rb())?this.player.pauseVideo():this.player.playVideo():this.player.Ma("onExpandMiniplayer")};
g.k.hg=function(){g.L(this.player.getRootNode(),"ytp-player-minimized",this.player.Ge())};
g.k.Jc=function(){this.Dc.Tb();this.xg.Tb()};
g.k.Lo=function(){this.Jc();this.rd&&this.rd.start()};
g.k.Cc=function(a){g.U(a.state,32)&&this.tooltip.hide()};
g.k.ob=function(){g.YO(this.Dc,0,this.player.Xa().getPlayerSize().width,!1);g.PO(this.Dc)};
g.k.oC=function(a){this.player.Ge()&&(0===a?this.hide():this.show())};
g.k.ac=function(){return this.tooltip};
g.k.re=function(){return!1};
g.k.Ie=function(){return!1};
g.k.Ih=function(){return!1};
g.k.qx=function(){};
g.k.Pl=function(){};
g.k.aq=function(){};
g.k.fm=function(){return null};
g.k.Bi=function(){return new g.bg(0,0,0,0)};
g.k.handleGlobalKeyDown=function(){return!1};
g.k.handleGlobalKeyUp=function(){return!1};
g.k.To=function(a,b,c,d,e){var f=0,h=d=0,l=g.Hg(a);if(b){c=g.xn(b,"ytp-prev-button")||g.xn(b,"ytp-next-button");var m=g.xn(b,"ytp-play-button"),n=g.xn(b,"ytp-miniplayer-expand-watch-page-button");c?f=h=12:m?(b=g.Fg(b,this.element),h=b.x,f=b.y-12):n&&(h=g.xn(b,"ytp-miniplayer-button-top-left"),f=g.Fg(b,this.element),b=g.Hg(b),h?(h=8,f=f.y+40):(h=f.x-l.width+b.width,f=f.y-20))}else h=c-l.width/2,d=25+(e||0);b=this.player.Xa().getPlayerSize().width;e=f+(e||0);l=g.de(h,0,b-l.width);e?(a.style.top=e+"px",
a.style.bottom=""):(a.style.top="",a.style.bottom=d+"px");a.style.left=l+"px"};
g.k.showControls=function(){};
g.k.ek=function(){};
g.k.Ej=function(){return!1};g.v(C4,g.mM);C4.prototype.create=function(){};
C4.prototype.Wh=function(){return!1};
C4.prototype.load=function(){this.player.hideControls();this.i.show()};
C4.prototype.unload=function(){this.player.showControls();this.i.hide()};g.xM.miniplayer=C4;})(_yt_player);
