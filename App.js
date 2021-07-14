/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {useState, useEffect} from 'react';
import type {Node} from 'react';

import {
  SafeAreaView,
  NativeModules,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
  Button,
} from 'react-native';

import Video from './src/ReactNativeVideo';

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

  const [layoutWidth, setLayoutWidth] = useState(0);
  const [shouldResume, setShouldResume] = useState(false);

  console.log(NativeModules);

  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar barStyle={isDarkMode ? 'light-content' : 'dark-content'} />
      <Text>Hello?</Text>

      <View
        onLayout={e => {
          console.log('1: ', e.nativeEvent.layout);
          setLayoutWidth(e.nativeEvent.layout.width);
        }}
        style={{backgroundColor: 'black', width: '100%', height: 234}}
        onStartShouldSetResponder={() => {
          NativeModules.NativePlayer.enterPictureInPicture();
          setShouldResume(true);
        }}>
        <Video
          resizeMode="contain"
          onLayout={e => console.log('2: ', e.nativeEvent.layout)}
          source={{
            uri: 'https://fbvslgdlnt.singularcdn.net.br/e20e1217-d55e-11eb-8291-d05099da38e8/playlist.m3u8',
          }} // Can be a URL or a local file.
          style={[
            {
              width: layoutWidth,
              height: '100%',
            },
            styles.backgroundVideo,
          ]}
        />
      </View>
    </SafeAreaView>
  );
};

let styles = StyleSheet.create({
  backgroundVideo: {
    position: 'absolute',
    top: 0,
    left: 0,
    bottom: 0,
    right: 0,
  },
});

export default App;
