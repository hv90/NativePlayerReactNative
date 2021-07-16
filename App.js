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
  TouchableOpacity,
  Dimensions,
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
  const [layoutHeight, setLayoutHeight] = useState(0);
  const [shouldResume, setShouldResume] = useState(false);
  const [shouldPause, setShouldPause] = useState(false);
  const [isInPiP, setIsInPiP] = useState(false);

  console.log(NativeModules);

  useEffect(() => {
    if (
      Math.round(Dimensions.get('screen').width * 100) / 100 -
        Math.round(layoutWidth * 100) / 100 <
      100
    ) {
      setIsInPiP(false);
    }
  }, [layoutWidth]);

  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar barStyle={isDarkMode ? 'light-content' : 'dark-content'} />

      <TouchableOpacity
        onPress={() => {
          setShouldResume(current => !current);
          shouldResume
            ? NativeModules.VideoView.play()
            : NativeModules.VideoView.pause();
        }}>
        <View
          onLayout={e => {
            console.log('1: ', e.nativeEvent.layout);
            setLayoutWidth(e.nativeEvent.layout.width);
          }}
          style={{width: '100%', height: 234}}
          onStartShouldSetResponder={() => {
            // setShouldResume(true);
          }}>
          <Video
            resize="contain"
            onLayout={e => console.log('2: ', e.nativeEvent.layout)}
            source={{
              uri: 'https://fbvslgdlnt.singularcdn.net.br/e20e1217-d55e-11eb-8291-d05099da38e8/playlist.m3u8',
            }} // Can be a URL or a local file.
            style={[
              {
                width: '100%',
                maxWidth: layoutWidth,
                height: '100%',
                maxHeight: 234,
              },
            ]}
          />
        </View>
      </TouchableOpacity>
      {!isInPiP && (
        <Button
          title="pip"
          onPress={() => {
            NativeModules.VideoView.enterPictureInPicture();
            setIsInPiP(true);
          }}
        />
      )}
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
  backgroundVideoPiP: {
    top: -85,
    left: 0,
    bottom: 0,
    right: 0,
  },
});

export default App;
