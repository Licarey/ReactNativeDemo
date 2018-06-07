'use strict';

import React from 'react';

import {
    AppRegistry,
    Text,
    TouchableHighlight,
    StyleSheet,
    DeviceEventEmitter,
    View
} from 'react-native';

import To from "./SimpleToast";

import NativeParamManage from "./NativeParamManage";

class MyAwesomeApp extends React.Component {
    render() {
        return (
            <View style={styles.container}>
                <TouchableHighlight onPress={this._onPressButton}>
                    <Text style={styles.hello}>调用android Toast</Text>
                </TouchableHighlight>
            </View>
        );
    }

    _onPressButton() {
        To.show("toast事件", To.SHORT);
        //DeviceEventEmitter.emit("androidCallRn" , "哈哈哈")
    }

    componentDidMount() {
        NativeParamManage.getParam((msg) => {
            To.show(msg.name, To.SHORT);
        });

        this.deEmitter = DeviceEventEmitter.addListener('androidCallRn',(msg)=> {
            To.show(msg , To.SHORT)
        });
    }

    componentWillUnmount() {
        this.deEmitter.remove();
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
    },
    hello: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
});

AppRegistry.registerComponent('MyAwesomeApp', () => MyAwesomeApp);