/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {useState, useEffect} from 'react';
import type {Node} from 'react';

import Video from 'react-native-video';

import {
  SafeAreaView,
  NativeModules,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
  Dimensions,
  Button,
} from 'react-native';

import {
  Colors,
  DebugInstructions,
  Header,
  LearnMoreLinks,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';

const App: () => Node = () => {
  const isDarkMode = useColorScheme() === 'dark';

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };

  const [window, setWindow] = useState(Dimensions.get('window'));

  console.log(NativeModules);

  useEffect(() => {
    setWindow(Dimensions.get('window'));
    console.log('updated: ', typeof window.height === typeof 100);
  }, [window]);

  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar barStyle={isDarkMode ? 'light-content' : 'dark-content'} />
      <Text>Hello?</Text>

      <View
        onLayout={e => console.log('1: ', e.nativeEvent.layout)}
        style={{backgroundColor: 'black', width: '100%', height: '100%'}}
        onStartShouldSetResponder={() => {
          NativeModules.NativePlayer.enterPictureInPicture();
        }}>
        <Video
          ref={ref => {
            console.log('ref: ', ref);
          }}
          resizeMode={'contain'}
          onLayout={e => console.log('2: ', e.nativeEvent.layout)}
          source={{
            uri: 'https://fbvslgdlnt.singularcdn.net.br/e20e1217-d55e-11eb-8291-d05099da38e8/playlist.m3u8',
          }} // Can be a URL or a local file.
          style={styles.backgroundVideo}
        />
      </View>
    </SafeAreaView>
  );
};

let styles = StyleSheet.create({
  backgroundVideo: {
    position: 'absolute',
    width: window.width,
    height: window.height,
    top: 0,
    left: 0,
    bottom: 0,
    right: 0,
  },
});

export default App;
